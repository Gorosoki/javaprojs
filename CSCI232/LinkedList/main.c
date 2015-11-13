/* 
 * File:   main.c
 * Author: Gavin
 *
 * Created on April 17, 2014, 3:09 AM
 */


#include <stdlib.h>
#include <stdio.h>


typedef struct alpha{
		char head_node;
		struct alpha *tail_ptr;
}struct_name;
void print_list(struct_name * head_root);


void main(int argc, char *argv[])
{
int iterator_i = 1;
struct_name * current_node = NULL;
struct_name *test_list = malloc(sizeof(struct_name));
	for(iterator_i; iterator_i < argc; iterator_i++)
		{
			int iterator_j = 0;
                        int iterator_k = 0, string_length = 0;
			char *input_string = argv[iterator_i];
                        while(input_string[iterator_k] != '\0')
                        {
                            string_length++;
                            iterator_k++;
                        }
                        //int thingy = sizeof(input_string)/sizeof(input_string[0]);
			//for (iterator_j; iterator_j < ((sizeof(input_string)/sizeof(input_string[0]))-1); iterator_j++)
			for (iterator_j; iterator_j < (string_length); iterator_j++)
                        {
					char temp_value = input_string[iterator_j];

					if(iterator_i == 1 && iterator_j == 0)
					{
						test_list->head_node = temp_value;
						test_list->tail_ptr = malloc(sizeof(struct_name));
						current_node = test_list->tail_ptr;
					}
					else
					{
						current_node->head_node = temp_value;
						current_node->tail_ptr = malloc(sizeof(struct_name));
						current_node = current_node->tail_ptr;
					}
				}
		}

//struct_name * test_list = malloc(sizeof(struct_name)):
//test_list->head = 'a';
//test_list->tail_ptr = malloc(sizeof(struct_name));

	print_list(test_list);
}

void print_list(struct_name * head_root) {
    struct_name * current_node = head_root;

    while (current_node != NULL) {
        printf("%c\n", current_node->head_node);
        current_node = current_node->tail_ptr;
    }
}



