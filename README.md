一些Java的基础练习，记录下来,都是在Eclipse上写的

1.InputExcersice

键盘录入多名学生的信息，以“姓名，数学成绩，语文成绩，英文成绩”的模式，将总分成绩由高到低和由低到高分别排序，并将学生信息进行排列的结果输出到文件中。

主函数在Test包里面。




2.MyBufferedReader

BufferedReader是一个很常用的字符流缓冲区对象，也是装饰者模式一个很常用的实际例子。

使用转换流Reader重写了自己的BufferedReader中的read()和readLine()方法，实现了读取文本，并且实现了一个小的应用：在读取时显示行号。




3.FileSplitAndStract

文件分割和合并

基于I/O流的文件分割和合并，分割的时候要生成存储信息的配置文件，合并的时候根据配置文件中的信息来合并文件成分割之前的格式。
先运行分割包里的，再运行合并包里的。

