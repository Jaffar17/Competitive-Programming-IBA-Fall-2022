package erratum

import (
	"errors"
)

func Use(opener ResourceOpener, input string) (err error) {
	resource, err := opener()
	for {
		if err != nil {
			_, ok := errors.AsType[TransientError](err)
			if ok {
				resource, err = opener()
			} else {
				return err
			}
		} else {
			break
		}
	}

	defer func() {
		_ = resource.Close()
	}()

	defer func() {
		r := recover()
		if r == nil {
			return
		}
		frobeErr, ok := r.(FrobError)
		if ok {
			resource.Defrob(frobeErr.defrobTag)
			err = frobeErr
		}
		e, ok := r.(error)
		if ok {
			err = e
		}
	}()

	resource.Frob(input)
	return nil
}
