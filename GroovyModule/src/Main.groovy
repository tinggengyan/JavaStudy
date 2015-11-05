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

