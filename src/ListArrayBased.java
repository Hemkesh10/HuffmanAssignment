public class ListArrayBased implements ListInterface {
    private static final int MAX_SIZE = 50; // Maximum size of the list
    private Object[] element; // Array to store elements
    private int itemCount; // Number of elements in the list

    public ListArrayBased() {
        element = new Object[MAX_SIZE]; // Allocate memory for the array
        itemCount = 0; // Initially, there are no elements in the list
    }

    public boolean isEmpty() {
        return (itemCount == 0); // Return true if the list is empty
    }


    public int size() {
        return itemCount; // Return the number of elements in the list
    }


    public void removeAll() {
        element = new Object[MAX_SIZE]; // Reallocate memory for the array
        itemCount = 0;
    }


    // Add an item to the list at the specified index
    public void add(int index, Object item) throws ListIndexOutOfBoundsException {

        // Check if the list is full
        if (itemCount > MAX_SIZE) {

            // Throw an exception if the list is full
            throw new ListException("ListException on add");
        }

        // Check if the index is valid
        if (index >= 1 && index <= itemCount + 1) {

            // Shift all elements from index to the end of the list
            for (int pos = itemCount; pos >= index; pos--) {
                element[translate(pos + 1)] = element[translate(pos)];
            }

            // Insert the new item
            element[translate(index)] = item;

            // Increment the number of elements in the list
            itemCount++;
        } else {
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on add");
        }
    }

    // Get an item from the list at the specified index
    public Object get(int index) throws ListIndexOutOfBoundsException {
        // Check if the index is valid
        if (index >= 1 && index <= itemCount) {
            return element[translate(index)];
        } else {
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
        }
    }

    // Bubble sort the list
    public void bubbleSortTree() {
        // Get the number of elements in the list
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                //compare the frequencies of two adjacent treenode
                if (((HuffmanObjects) ((TreeNode) element[j]).getItem())
                        .getFreq() > ((HuffmanObjects) ((TreeNode) element[j + 1]).getItem()).getFreq()) {
                    // swap the nodes if they are not in order
                    TreeNode temp = (TreeNode) element[j];
                    element[j] = element[j + 1];
                    element[j + 1] = temp;
                }
            }
        }
    }



    // Remove an item from the list at the specified index
    public void remove(int index) throws ListIndexOutOfBoundsException {

        // Check if the index is valid
        if (index >= 1 && index <= itemCount) {
            // Shift all elements from index to the end of the list
            for (int pos = index + 1; pos <= size(); pos++) {
                element[translate(pos -1)] = element[translate(pos)];
            }
            // Decrement the number of elements in the list
            itemCount--;
        } else {
            throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
        }
    }


    // Translate the index to the array index
    private int translate(int index) {
        return index - 1;
    }
}
