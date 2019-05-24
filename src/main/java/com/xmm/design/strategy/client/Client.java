package com.xmm.design.strategy.client;

import com.xmm.design.strategy.context.MemberPrice;
import com.xmm.design.strategy.impl.AdvancedMemberStrategy;
import com.xmm.design.strategy.impl.IntermediateMemberStrategy;
import com.xmm.design.strategy.impl.PrimaryMemberStrategy;
import com.xmm.design.strategy.service.MemberStrategy;

public class Client {
    public static void main(String[] args) {
        MemberStrategy memberStrategy=new IntermediateMemberStrategy();
        MemberPrice memberPrice=new MemberPrice(memberStrategy);
        Double IntermediatePrice=memberPrice.calculatePrice(10.0);
        System.out.println("该会员类型打折后是:"+IntermediatePrice);

        MemberStrategy memberStrategy1=new AdvancedMemberStrategy();
        MemberPrice memberPrice1=new MemberPrice(memberStrategy1);
        Double advancedPrice1=memberPrice1.calculatePrice(10.0);
        System.out.println("该会员类型打折后是:"+advancedPrice1);

        MemberStrategy memberStrategy2=new PrimaryMemberStrategy();
        MemberPrice memberPrice2=new MemberPrice(memberStrategy2);
        Double primaryPrice=memberPrice2.calculatePrice(10.0);
        System.out.println("该会员类型打折后是:"+primaryPrice);
        IntermediateMemberStrategy d = new IntermediateMemberStrategy();
        System.out.println("该会员类型打折后是:"+d.calculatePrice(10));

    }
}
