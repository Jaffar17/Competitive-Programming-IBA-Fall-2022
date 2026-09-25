package robotname

import (
	"errors"
	"math/rand/v2"
	"strings"
)

const (
	letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	digits  = "0123456789"
)

var existingNames = map[string]bool{}

type Robot struct {
	name string
}

func (r *Robot) Name() (string, error) {
	if r.name != "" {
		return r.name, nil
	}

	for {
		name := generateRobotName()
		if existingNames[name] == false {
			r.name = name
			existingNames[name] = true
			return name, nil
		}
	}

	return "", errors.New("Ran out of names")
}

func (r *Robot) Reset() {
	existingNames[r.name] = false
	*r = Robot{}
}

func generateRobotName() string {
	var roboName strings.Builder

	for i := 0; i < 5; i++ {
		if i < 2 {
			roboName.WriteByte(letters[rand.IntN(26)])
		} else {
			roboName.WriteByte(digits[rand.IntN(10)])
		}
	}

	return roboName.String()
}
