class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        //Array to store the frequency of each element
        int[] frequency = new int[arr.length];

        //count the frequency of each element
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            frequency[i] = count;
        }

        //check if frquencies are unique
        for (int i = 0; i < frequency.length; i++) {
            for (int j = i + 1; j < frequency.length; j++) {

                //avoid comparing the same element with itself (same value)
                if (i != j && arr[i] == arr[j]) {
                    continue;
                }
                if (frequency[i] == frequency[j]) {
                    return false; //found two elements with the same frequency
                }
            }
        }

        //if all the frequencies are unique
        return false;
    }
}