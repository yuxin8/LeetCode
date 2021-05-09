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
	Node *root = newNode(5);
	root->left = newNode(3);
	root->right = newNode(6);
	root->left->left = newNode(2);
	root->left->right = newNode(4);
//	root->right->left = newNode(9);
	root->right->right = newNode(7);
	cout << "Level Order traversal of binary tree is \n";
	queue<Node *> q1;
	Node* node;
	q1.push(root);
	while (!q1.empty()){
		node = q1.front();
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
5 3 6 2 4 7
*/
