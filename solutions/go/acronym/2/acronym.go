// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package acronym should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package acronym

import (
	"strings"
	"unicode"
)

// Abbreviate should have a comment documenting it.
func Abbreviate(s string) string {
	newWord := true
	var result strings.Builder

	for _, char := range s {
		switch {
		case unicode.IsLetter(char):
			if newWord == true {
				result.WriteRune(unicode.ToUpper(char))
				newWord = false
			}
		case char == '\'':
			// apostrophe case
		default:
			newWord = true
		}

	}
	return result.String()
}
