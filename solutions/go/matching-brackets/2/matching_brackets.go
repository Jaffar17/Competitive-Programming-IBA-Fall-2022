package matchingbrackets

func Bracket(input string) bool {
	brackets := map[rune]rune{
		']': '[',
		'}': '{',
		')': '(',
	}

	var stack []rune

	for _, char := range input {
		switch char {
		case '[', '{', '(':
			stack = append(stack, char)
		case ']', '}', ')':
			if len(stack) > 0 {
				last := stack[len(stack)-1]
				stack = stack[:len(stack)-1]

				if last != brackets[char] {
					return false
				}
			} else {
				return false
			}
		}
	}

	return len(stack) == 0
}
