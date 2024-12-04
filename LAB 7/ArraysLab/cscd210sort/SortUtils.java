package cscd210sort;

/**
 * The SortUtils class sorts arrays in ascending order
 * @NOTE This API is for information.   <br>
 * Do not write this code.  Just call it.   */
 
public class SortUtils
{
   /**
    * The selectionSort method sorts the array of integers in ascending order
    *
    * @param myArray Representing an array of integers
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than zero
    */

   public static void selectionSort(final int [] myArray)
   {
      if(myArray == null || myArray.length < 1)
         throw new IllegalArgumentException("Bad params selectionSort");
         
      int search, start, min;
      int temp;
      
      for(start = 0; start < myArray.length - 1; start++)
      {
         min = start;
         
         for(search = start + 1; search < myArray.length; search++)
         {
            if(myArray[search] < myArray[min])  // finding the min
               min = search;
         }// end for search
         
         temp = myArray[start];
         myArray[start] = myArray[min];
         myArray[min] = temp;   
      
      }// end for start
   }// end method
}// end class
