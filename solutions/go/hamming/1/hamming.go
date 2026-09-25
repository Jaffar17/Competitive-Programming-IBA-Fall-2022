package hamming

import "errors"

func Distance(a, b string) (int, error) {
	distance := 0
	if len(a) != len(b) {
		return distance, errors.New("dna strings are not equal in length")
	}

	for index, _ := range a {
		if a[index] != b[index] {
			distance += 1
		}
	}

	return distance, nil
}
