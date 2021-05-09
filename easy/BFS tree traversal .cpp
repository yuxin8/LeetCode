#include <iostream>
#include <queue>
using namespace std;
struct Node {
	int data;
	struct Node *left, *right;
};
Node* newNode(int data) {
	Node *temp = new Node;
	temp->data = data;
	temp->left = temp->right = NULL;
	return temp;
}
int main() {
	Node *root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(9);
	root->right->right = newNode(10);
	cout << "Level Order traversal of binary tree is \n";
	queue<Node *> q1;
	q1.push(root);
	while (!q1.empty()){
		Node *node = q1.front();
		cout << node->data << " ";
		q1.pop();
		if (node->left != NULL)
			q1.push(node->left);
		if (node->right != NULL)
			q1.push(node->right);
	}
	return 0;
}

/*
output: 
Level Order traversal of binary tree is 
1 2 3 4 5 9 10 
*/
