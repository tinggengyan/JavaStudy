//1.��ӡ����
println("Hello world!");
//2. ��������
int a = 3;
int b = 20;
println(a + b)

//3. �ļ���ȡ
String baseDir = "F:\\";
String fileName = "Hello.txt";

//new File(baseDir, fileName).eachLine {
//    line -> println(line);
//}

String path=new File(baseDir,fileName).absolutePath;
println(path);

