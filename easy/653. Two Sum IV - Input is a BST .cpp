/*
Given the root of a Binary Search Tree and a target number k, 
return true if there exist two elements in the BST such that their sum is equal to the given target.

This code is using this example to do the track:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false 0

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true 1

Input: root = [2,1,3], k = 4
Output: true 1

Input: root = [2,1,3], k = 1
Output: false 0

Input: root = [2,1,3], k = 3
Output: true 1
*/


// C++ program to demonstrate insertion
// in a BST recursively.
#include <iostream>
#include <set>
#include <iterator>
using namespace std;

class BST
{
	int data;
	BST *left, *right;

public:
	// Default constructor.
	BST();

	// Parameterized constructor.
	BST(int);

	// Insert function.
	BST* Insert(BST*, int);

	// Inorder traversal.
	void Inorder(BST*);

	bool find(BST* root, int k, set<int> set1);
	bool findTarget(BST* root, int k);
};

// Default Constructor definition.
BST ::BST()
	: data(0)
	, left(NULL)
	, right(NULL)
{
}

// Parameterized Constructor definition.
BST ::BST(int value)
{
	data = value;
	left = right = NULL;
}

// Insert function definition.
BST* BST ::Insert(BST* root, int value)
{
	if (!root)
	{
		// Insert the first node, if root is NULL.
		return new BST(value);
	}

	// Insert data.
	if (value > root->data)
	{
		// Insert right node data, if the 'value'
		// to be inserted is greater than 'root' node data.

		// Process right nodes.
		root->right = Insert(root->right, value);
	}
	else
	{
		// Insert left node data, if the 'value'
		// to be inserted is greater than 'root' node data.

		// Process left nodes.
		root->left = Insert(root->left, value);
	}

	// Return 'root' node, after insertion.
	return root;
}
/*
// Inorder traversal function.
// This gives data in sorted order.
void BST ::Inorder(BST* root)
{
	if (!root) {
		return;
	}
	Inorder(root->left);
	cout << root->data << endl;
	Inorder(root->right);
}
*/
bool BST::find(BST* root, int k, set<int> set1)
{
	
	if (root == NULL) {
		cout << "now false\n";
		return false;
	}
	if (set1.find(k - root->data) != set1.end()) {
		cout << "root now = " << root->data << endl;
		return true;
	}
	cout << "root = " << root->data << endl;
	set1.insert(root->data);
	return find(root->left, k, set1) || find(root->right, k, set1);
}

bool BST::findTarget(BST* root, int k)
{
	set<int> set1;
	return find(root, k, set1);
}

// Driver code
int main()
{
	BST b, *root = NULL;
	root = b.Insert(root, 5);
	b.Insert(root, 3);
	b.Insert(root, 6);
	b.Insert(root, 2);
	b.Insert(root, 4);
	//b.Insert(root, NULL);
	b.Insert(root, 7);

	//b.Inorder(root);
	int k = 28;
	bool result = b.findTarget(root, k);
	cout << "result = " << result << endl;
  
	return 0;
}

/* 
output: 

root = 5
root = 3
root = 2
now false
now false
root = 4
now false
now false
root = 6
now false
root = 7
now false
now false
result = 0
*/



 
