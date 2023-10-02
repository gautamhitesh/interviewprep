package main

import "fmt"

//reverse string

//string to array

//array to string

//print ASCII (rune)

func main() {

	str := "Hello World"
	fmt.Println(reverseString(str))
	fmt.Println(reverseStringImproved(str))

}

func reverseString(str string) string {
	res := ""
	for _, v := range str {
		res = string(v) + res //convert rune to string
	}
	return res
}

func reverseStringImproved(s string) string {
	temp := []byte(s)
	for i, j := 0, len(temp)-1; i < j; {
		temp[i], temp[j] = temp[j], temp[i]
		i++
		j--
	}
	return string(temp)
}
