package chapter02;

public class DriverForModifiedArray {
    public static void main(String[] args) {
        ArrayBagModified arrayBagModified = new ArrayBagModified();
        System.out.println("Constructor, no input");
        System.out.println("Size: " + arrayBagModified.size());
        System.out.println("Empty: " + arrayBagModified.isEmpty());

        ArrayBagModified arrayBagModified2 = new ArrayBagModified(5);
        System.out.println("Constructor, with input");
        System.out.println("Size: " + arrayBagModified2.size());
        System.out.println("Empty: " + arrayBagModified2.isEmpty());

        arrayBagModified.add(1);
        arrayBagModified.add(2);
        arrayBagModified.add(3);

        arrayBagModified2.add(3);
        arrayBagModified2.add(4);
        arrayBagModified2.add(5);

        System.out.println("Displaying the arrays:");
        System.out.println("am1: " + arrayBagModified);
        System.out.println("am2: " + arrayBagModified2);

        arrayBagModified.addAll(arrayBagModified2);

        try {
            arrayBagModified.equals(arrayBagModified2);
        } catch (EmptyBagException e) {
            e.printStackTrace();
        }

        System.out.println("Displaying the arrays after adding am2 to am1:");
        System.out.println("array modified: " + arrayBagModified);
        System.out.println("array modified 2: " + arrayBagModified2);

        ArrayBagModified arrayBagModifiedUnion = new ArrayBagModified();

        System.out.println("Trying to remove an entry from an empty array modified union object:");
        try {
            arrayBagModifiedUnion.remove(1);
        } catch (EmptyBagException e) {
            System.out.println("Message: " + e.getMessage() + "\n");
        }

        System.out.println("The union of am1 and am2");
        arrayBagModifiedUnion = (ArrayBagModified) arrayBagModified.union(arrayBagModified2);

        System.out.println("Displaying the am union:");
        System.out.println("array modified union: " + arrayBagModifiedUnion);

        System.out.println("Does am2 contain 2: " + arrayBagModified2.contains(2));
        System.out.println("Does am2 contain 3: " + arrayBagModified2.contains(3));

        try {
            System.out.println("Removing 3 from am1:");
            System.out.println("am1 before: " + arrayBagModified);
            arrayBagModified.remove(3);
            System.out.println("am1 after: " + arrayBagModified);
        } catch (EmptyBagException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Removing a random element from am2:");
            System.out.println("am2 before: " + arrayBagModified2);
            arrayBagModified2.removeRandom();
            System.out.println("am2 after: " + arrayBagModified2);
        } catch (EmptyBagException e) {
            e.printStackTrace();
        }
    }
}
