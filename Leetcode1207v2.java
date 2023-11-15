class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        //sort the array so that all duplicates are next to each other
        Arrays.sort(arr);

        //temporary array to store unique frequencies
        int[] freq = new int [arr.length];
        int freqIndex = 0; //index for the frequency array

        //count the occurences of each unique number
        for (int i = 0; i < arr.length; i++) {
            int count = 1; //sthart counting from 1

            //count duplicates which are now consecutive due to sorting
            while (i + 1 < arr.length && arr[i] == arr[i+1]) {
                count++;
                i++;
            }

            //store this count in the frequency array
            freq[freqIndex++] = count;
        }

        //sort the frequency array to group the same frequencies together
        Arrays.sort(freq,0,freqIndex);

        //check if there are any duplicate frequencies
        for (int i = 0; i < freqIndex - 1; i++) {

            //check the next element
            if (freq[i] == freq[i + 1]) {
                return false; //duplicate frequency found
            }
        }

        //all frequencies are unique
        return true;
    }
}