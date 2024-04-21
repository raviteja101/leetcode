class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        Stack<Integer> sandwichesStack = new Stack<>();
        for(int i=0; i<students.length; i++) {
            studentsQueue.offer(students[i]);
            sandwichesStack.push(sandwiches[students.length-i-1]);
        }
        int lastStudent = 0;
        while(!sandwichesStack.isEmpty()) {
            if(studentsQueue.peek() == sandwichesStack.peek()) {
                studentsQueue.remove();
                sandwichesStack.pop();
                lastStudent = 0;
            } else {
                int element = studentsQueue.remove();
                studentsQueue.add(element);
                lastStudent++;
            }
            if(lastStudent == studentsQueue.size()) {
                return studentsQueue.size();
            }
        }
        return 0;     
    }
}