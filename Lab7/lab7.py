# Import the necessary module
import sys

def main():
    # Asking user to input matrix size
    rows = int(input("Enter matrix size: "))

    if rows < 1:
        print("\nInvalid matrix size")
        return

    # Asking user to input the filler character
    filler = input("\nEnter filler character: ")
    
    if len(filler) == 0:
        print("\nNo filler character entered")
        return
    elif len(filler) > 1:
        print("\nToo many characters entered as filler")
        return

    # Creating matrix with specific triangular shape
    arr = []
    for i in range(rows // 2):
        arr.insert(i, [filler] * (i + 1))
        arr.insert(-i, [filler] * (i + 1))

    if rows % 2 == 1:
        arr.insert(rows // 2, [filler] * (rows // 2 + 1))

    # Displaying the matrix
    for i in range(len(arr)):
        # Printing leading spaces
        for j in range(rows - len(arr[i])):
            print("  ", end="")
        
        # Printing matrix elements
        for j in range(len(arr[i])):
            print(arr[i][j], end=" ")
        
        # Moving to the next line
        print()

if __name__ == "__main__":
    main()