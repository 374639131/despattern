package com.atguigu.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: DesignPattern
 * @description:
 * @author: Li huachang
 * @create: 2020-06-28 14:11
 */

class Member{
    private int size;
    private boolean isUsed;
    private String id;

    public Member(int size, boolean isUsed, String id) {
        this.size = size;
        this.isUsed = isUsed;
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Member{" +
                "size=" + size +
                ", isUsed=" + isUsed +
                ", id='" + id + '\'' +
                '}';
    }
}


class MemberFactory{

    private static  List<Member> memberList=new ArrayList<>();

    public static Member getMember(int size){
        Member reMember =null;
        for (int i=0;i<memberList.size();i++) {
            Member member =memberList.get(i);
            if (member.getSize()==size&&member.isUsed()==false)
            {
                reMember=member;
                member.setUsed(true);
                memberList.set(i,member);
                System.out.println("内存池已经有改内存，直接返回");
                break;
            }
        }
        if (reMember==null)
        {
            reMember=new Member(32,false, UUID.randomUUID().toString());
            memberList.add(reMember);
            System.out.println("新建一块内存块，并插入内存池");
        }
        return reMember;
    }

    public static void relaseMember(String id){
        for (int i = 0; i < memberList.size(); i++) {
            Member member =memberList.get(i);
            if (member.getId().equals(id))
            {
                member.setUsed(false);
                memberList.set(i,member);
                System.out.println("已经释放内存");
                break;
            }
        }
    }


}




public class FlyweightDemo {

    public static void main(String[] args) {
        Member member = MemberFactory.getMember(32);
        Member member2 = MemberFactory.getMember(32);
        System.out.println(member==member2);
        MemberFactory.relaseMember(member.getId());
    }

}