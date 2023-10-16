package main

import "fmt"

//code to
//append
//prepend
//traverse
//remove
//count
//reverse
//reverse recursively

type Node struct {
	val  int
	next *Node
}

func main() {
	var root *Node
	for i := 0; i < 10; i++ {
		root = prepend(root, i)
	}
	traverse(root)
	fmt.Println()
	for i := 0; i < 10; i++ {
		root = append(root, i+10)
	}
	traverse(root)
	fmt.Println()
	remove(root, 0)
	traverse(root)
	fmt.Println()
	fmt.Printf("Length of the linkedlist: %d", length(root))
	fmt.Println()
	fmt.Println(detectLoop(root))
	// ptr := root
	// count := 0
	// prevPtr := root
	//add a loop to the linkedlist
	// for ptr.next != nil {
	// 	if count == 10 {
	// 		prevPtr = ptr
	// 	}
	// 	ptr = ptr.next
	// 	count++
	// }
	// ptr.next = prevPtr
	// fmt.Println(detectLoop(root))
	root = reverse(root)
	traverse(root)
	fmt.Println()
	root = reverseRecursive(root)
	traverse(root)
}

func prepend(root *Node, val int) *Node {
	if root == nil {
		fmt.Println("Empty list")
		return &Node{val, nil}
	}
	return &Node{val, root}
}

func append(root *Node, val int) *Node {
	if root == nil {
		fmt.Println("Empty List")
		return &Node{val, nil}
	}
	ptr := root
	for ptr.next != nil {
		ptr = ptr.next
	}
	ptr.next = &Node{val, nil}
	return root
}

func traverse(root *Node) {
	for root != nil {
		fmt.Printf("%d --> ", root.val)
		root = root.next
	}
}

func remove(root *Node, val int) bool {
	if root == nil {
		fmt.Println("Empty List")
		return false
	}
	ptr := root
	prev := ptr
	for ptr != nil {
		if ptr.val == val {
			prev.next = ptr.next
			return true
		}
		prev = ptr
		ptr = ptr.next
	}
	return false
}

func length(root *Node) int {
	count := 0
	for root != nil {
		root = root.next
		count++
	}
	return count
}

//to do: what to return
func detectLoop(root *Node) (bool, *Node) {
	if root == nil {
		return false, nil
	}
	ptr := root
	fastPtr := root
	for fastPtr != nil && fastPtr.next != nil {
		ptr = ptr.next
		fastPtr = fastPtr.next.next
		if ptr == fastPtr {
			return true, fastPtr.next
		}
	}
	return false, nil
}

func reverse(root *Node) *Node {
	if root == nil || root.next == nil {
		return root
	}
	ptr := root
	var prev *Node
	for ptr != nil {
		next := ptr.next
		ptr.next = prev
		prev = ptr
		ptr = next
	}
	return prev
}
func reverseRecursive(root *Node) *Node {
	if root == nil || root.next == nil {
		return root
	}
	newHead := reverseRecursive(root.next)
	root.next.next = root
	root.next = nil
	return newHead
}
