package anagram

import (
	"maps"
	"strings"
	"unicode"
)

func Detect(subject string, candidates []string) []string {
	freq := map[rune]int{}

	for _, char := range subject {
		freq[unicode.ToLower(char)] += 1
	}

	var result []string
	for _, word := range candidates {
		if len(word) != len(subject) || strings.ToLower(word) == strings.ToLower(subject) {
			continue
		}
		freqCount := map[rune]int{}
		for _, char := range word {
			freqCount[unicode.ToLower(char)] += 1
		}

		if maps.Equal(freq, freqCount) {
			result = append(result, word)
		}
	}

	return result
}
