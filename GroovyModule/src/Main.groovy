//1.打印内容
println("Hello world!");
//2. 变量运算
int a = 3;
int b = 20;
println(a + b)

//3. 文件读取
String baseDir = "F:\\";
String fileName = "Hello.txt";

//new File(baseDir, fileName).eachLine {
//    line -> println(line);
//}

String path=new File(baseDir,fileName).absolutePath;
println(path);


//定义一个函数，有一个参数的函数
def func1={
    it->println(it);
}

func1(2);

//含有两个参数的函数
def func2={
    it1,it2->
        print(it1+it2)
}

func2(1,2);

