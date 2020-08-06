package com.sy;

import java.util.Scanner;

/**
 * Mini的DVD管理系统
 */
public class DvdMgr {

    public static void main(String[] args) {
        //2.初始化信息(最多存放6张DVD)
        int[] state = new int[7];//借出状态0未借1已借出
        String[] name=new String[7];//名称
        int[] date = new int[7];//日期
        int[] count = new int[7];//次数
        state[0] = 1;
        name[0]="罗马假日";
        date[0]=1;
        count[0]=15;
        state[1] = 0;
        name[1]="风声鹤唳";
        date[1]=0;
        count[1]=12;
        state[2] = 0;
        name[2]="浪漫满屋";
        date[2]=0;
        count[2]=30;

        //1.菜单展示,菜单的切换
        int num = 0;
        do{
            System.out.println("欢迎使用DVD管理器");
            System.out.println("---------------------");
            System.out.println("1.新增DVD");
            System.out.println("2.查看DVD");
            System.out.println("3.删除DVD");
            System.out.println("4.借出DVD");
            System.out.println("5.归还DVD");
            System.out.println("6.退出DVD");
            System.out.println("---------------------");
            System.out.println("请选择:");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            //switch适用于等值判断
            switch (choice) {
                case 1:
                    System.out.println("--->新增DVD");
                    System.out.println("请输入DVD的名称:");
                    String inname = scanner.next();
                    for(int i=0;i<name.length-1;i++){
                        if(name[i]==null){
                            name[i] = inname;
                            break;
                        }
                    }
                    System.out.println("新增<<"+inname+">>成功");
                    break;
                case 2:
                    System.out.println("--->查看DVD");
                    System.out.println("序号\t状态\t\t名称\t\t借出日期\t借出次数");
                    for(int i=0;i<name.length-1;i++){
                        System.out.print((i+1)+"\t");
                        if(state[i]==0){
                            System.out.print("可借  \t");
                        }else{
                            System.out.print("已借出\t");
                        }
                        System.out.print(name[i]+"\t");
                        if(date[i]!=0){
                            System.out.print(date[i]+"\t\t");
                        }else{
                            System.out.print("\t\t");
                        }
                        System.out.println(count[i]+"次");
                        if(name[i+1]==null){
                            break;
                        }
                    }

                    break;
                case 3:
                    System.out.println("--->删除DVD");
                    //两上状态要判断 名称是否存在,是否已借出
                    System.out.println("请输入DVD的名称:");
                    String delname = scanner.next();
                    for(int i=0;i<name.length-1;i++){
                        if(delname.equals(name[i])){
                            //找到匹配信息,判断是否已借出
                            if(state[i]==0){
                                    //删除操作,数组删除是移位操作
                                    for(int j=i;j<name.length-1;j++){
                                        name[j]=name[j+1];
                                        state[j]=state[j+1];
                                        count[j]=count[j+1];
                                        date[j]=date[j+1];
                                        if(name[j+1]==null){
                                            System.out.println("删除<<"+delname+">>成功!");
                                            break;
                                        }
                                    }
                            }else{
                                System.out.println("该DVD已借出,无法删除!");
                            }
                            break;
                        }else if(name[i]==null){
                            System.out.println("没有找到匹配的信息");
                            break;
                        }
                    }

                    break;
                case 4:
                    System.out.println("--->借出DVD");

                    break;

                case 5:
                    System.out.println("--->归还DVD");

                    break;
                case 6:
                    System.out.println("--->退出DVD");
                    System.exit(0);
                    break;
                default:
                    System.out.println("非法操作");
                    System.exit(1);
            }

            System.out.println("输入0返回:");
            num = scanner.nextInt();
            while(num !=0){
                System.out.println("请重新输入0:");
                num = scanner.nextInt();
            }
        }while(num==0);

    }
}
