package XunLei;

//��̬�����:��java��ʹ��static�ؼ��������Ĵ���顣��̬�����ڳ�ʼ���࣬Ϊ������Գ�ʼ����ÿ����̬�����ֻ��ִ��һ�Ρ�����JVM�ڼ�����ʱ��ִ�о�̬����飬���Ծ�̬���������������ִ�С�
//������а��������̬����飬��ô������"�ȶ���Ĵ�����ִ�У�����Ĵ����ִ��"��
//ע�⣺1 ��̬����鲻�ܴ������κη������ڡ�2 ��̬����鲻��ֱ�ӷ��ʾ�̬ʵ��������ʵ����������Ҫͨ�����ʵ�����������ʡ�


class Code{
  {
    System.out.println("Code�Ĺ����");
  }

  static{
      System.out.println("Code�ľ�̬�����");
      }

  public Code(){
      System.out.println("Code�Ĺ��췽��");
      }
  }


public class CodeBlock03{
   {
    System.out.println("CodeBlock03�Ĺ����");    
   }

   static{
      System.out.println("CodeBlock03�ľ�̬�����");
      }

      public CodeBlock03(){
           System.out.println("CodeBlock03�Ĺ��췽��");
          }

    public static void main(String[] args){
          System.out.println("CodeBlock03��������");
          new Code();
          new Code();
          new CodeBlock03();
          new CodeBlock03();
        }
  }
/*
CodeBlock03�ľ�̬�����
CodeBlock03��������
Code�ľ�̬�����
Code�Ĺ����
Code�Ĺ��췽��
Code�Ĺ����
Code�Ĺ��췽��
CodeBlock03�Ĺ����
CodeBlock03�Ĺ��췽��
CodeBlock03�Ĺ����
CodeBlock03�Ĺ��췽��
*/
