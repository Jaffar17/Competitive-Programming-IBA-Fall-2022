package anagram

import (
	"strings"
)

func Detect(subject string, candidates []string) []string {
	freq := map[rune]int{}
	subLower := strings.ToLower(subject)

	for _, char := range subLower {
		freq[char] += 1
	}

	var result []string
	freqCount := map[rune]int{}

	for _, word := range candidates {
		wordLower := strings.ToLower(word)
		if len(wordLower) != len(subLower) || strings.ToLower(word) == subLower {
			continue
		}
		clear(freqCount)

		isAnagram := true
		for _, char := range wordLower {
			freqCount[char] += 1
			if freqCount[char] > freq[char] {
				isAnagram = false
				break
			}
		}

		if isAnagram {
			result = append(result, word)
		}
	}

	return result
}
