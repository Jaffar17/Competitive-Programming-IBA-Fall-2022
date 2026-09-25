package matchingbrackets

func Bracket(input string) bool {
	brackets := map[rune]rune{
		']': '[',
		'}': '{',
		')': '(',
	}

	var stack []rune

	for _, char := range input {
		if char == '[' || char == '{' || char == '(' {
			stack = append(stack, char)
		}

		if char == ']' || char == '}' || char == ')' {
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

	if len(stack) > 0 {
		return false
	}
	return true
}
