package collatzconjecture

import "errors"

func CollatzConjecture(n int) (int, error) {
	steps := 0
	for {
		if n == 1 {
			return steps, nil
		} else if n <= 0 {
			return 0, errors.New("n is less than or equal to zero")
		} else if n%2 != 0 {
			n = (n * 3) + 1
			steps += 1
		} else {
			n = n / 2
			steps += 1
		}
	}
}
