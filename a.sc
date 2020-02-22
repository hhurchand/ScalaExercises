object a {

// EXERCISE in class : MAXIMUM

  def max(x:Int,y:Int):Int={if(x < y)y else x}    //> max: (x: Int, y: Int)Int
  
  def callMax(x: Int,y:Int, f: (Int,Int)  => Int) : Int = {
  	f(x,y)
  }                                               //> callMax: (x: Int, y: Int, f: (Int, Int) => Int)Int

  println(callMax(3,10,max))                      //> 10
  
// ______________________________________________________________________________________

// EXERCISE IN CLASS : FIBONACCI


 def fiboSeq2(n : Int): Int = { if(n==0)0 else {if (n==1)1 else fiboSeq2(n-1)+fiboSeq2(n-2)}}
                                                  //> fiboSeq2: (n: Int)Int
 
 for (i <- 0 to 10){
 println(fiboSeq2(i))}                            //> 0
                                                  //| 1
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
                                                  //| 55


// ______________________________________________________________________________________
// EXERCISE 1 : FACTORIAL FUNCTION
 def fact(n : Int): Int = { if(n==0)1 else n*fact(n-1)}
                                                  //> fact: (n: Int)Int
 
 def call_n_print(x:Int,f:Int=>Int):Int = {
 f(x)
 }                                                //> call_n_print: (x: Int, f: Int => Int)Int
 
 // Example 1
 println(call_n_print(5,fact))                    //> 120
 // Example 2
 println(call_n_print(19,fact))                   //> 109641728

// ______________________________________________________________________________________

// EXERCISE 2 -- USING LIST
// 2-a
  def makeToList(x : Int) : List[Int] = (1 to x).toList
                                                  //> makeToList: (x: Int)List[Int]
 

  def f(x : Int):Int={
  val p = makeToList(x)
  return p.product
  }                                               //> f: (x: Int)Int
  
  println(f(5))                                   //> 120
// 2-b Recompute 5! using reduce
  val l1 = List(1,2,3,4,5)                        //> l1  : List[Int] = List(1, 2, 3, 4, 5)
  val Five_factorial = l1.reduce((x,y)=>x*y)      //> Five_factorial  : Int = 120
  println(s"Method reduce for 5! ${Five_factorial}")
                                                  //> Method reduce for 5! 120
                                                  
                                                  
// 2-c GENERALISED METHOD
  def Reduce(n: Int) : Int = {
   makeToList(n).reduce((a,b)=>a*b)
  }                                               //> Reduce: (n: Int)Int
  
  def generalMethod(n: Int, Reduce:Int => Int): Int = {
  Reduce(n)
  }                                               //> generalMethod: (n: Int, Reduce: Int => Int)Int
//  println(l.reduce((x,y)=>x*y))
  println(generalMethod(6,Reduce))                //> 720
// ______________________________________________________________________________________

// EXERCISE 3

 val list2 = (1 to 45).toList                     //> list2  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                                                  //| , 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 3
                                                  //| 4, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45)


 val num_div4 = list2.filter(_%4==0)              //> num_div4  : List[Int] = List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44)


 println(s"sum of numbers from 1 to 45 divisible by 4 = ${num_div4.sum}")
                                                  //> sum of numbers from 1 to 45 divisible by 4 = 264

 val list_Square = list2.map(x=>x*x)              //> list_Square  : List[Int] = List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 
                                                  //| 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484, 529, 576, 625, 676, 
                                                  //| 729, 784, 841, 900, 961, 1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 16
                                                  //| 00, 1681, 1764, 1849, 1936, 2025)

 val num_sumSquare = list_Square.filter(_%3==0)   //> num_sumSquare  : List[Int] = List(9, 36, 81, 144, 225, 324, 441, 576, 729, 
                                                  //| 900, 1089, 1296, 1521, 1764, 2025)
 

  val less_20 = num_sumSquare.filter(_<20)        //> less_20  : List[Int] = List(9)
 
  println(s"Sum of Squares of integers in [1,45] divisible by 3 and which are less than 20 = ${less_20.map(x=>x*x).sum}")
                                                  //> Sum of Squares of integers in [1,45] divisible by 3 and which are less than
                                                  //|  20 = 81
}