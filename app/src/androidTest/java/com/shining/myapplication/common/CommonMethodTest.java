package com.shining.myapplication.common;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-03.
 */
public class CommonMethodTest {
    private CommonMethod commonMethod;
    private static String TAG="zhuanlan";
    @Before
    public void setUp() throws Exception {
        commonMethod = new CommonMethod();
    }

    @Test
    public void getStandardDate() throws Exception {
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        String time="2016-04-06 11:56:11";
        Log.d(TAG,"测试一:"+time);
        Date date = format.parse(time);
        Log.d(TAG,"Test day is "+date.getTime()+"");

        long today = System.currentTimeMillis();

        Log.d(TAG,"today is "+today+"");

        String before = commonMethod.getStandardDate(date.getTime());
        Log.d(TAG,"测试一结果 "+before);

        Log.d(TAG,"------------");

        String time2="2016-11-03 11:56:11";
        Log.d(TAG,"测试二:"+time2);
        Date date2 = format.parse(time2);
        //long today = System.currentTimeMillis();
        String before2 = commonMethod.getStandardDate(date2.getTime());
        Log.d(TAG,"测试二结果 "+before2);

        Log.d(TAG,"------------");

        String time3="2016-11-02 11:56:11";
        Log.d(TAG,"测试三:"+time3);
        Date date3 = format.parse(time3);
        //long today = System.currentTimeMillis();
        String before3 = commonMethod.getStandardDate(date3.getTime());
        Log.d(TAG,"测试三结果 "+before3);

        Log.d(TAG,"------------");

        String time4="2015-11-02 11:56:11";
        Log.d(TAG,"测试四:"+time4);
        Date date4 = format.parse(time4);
        //long today = System.currentTimeMillis();
        String before4 = commonMethod.getStandardDate(date4.getTime());
        Log.d(TAG,"测试四结果 "+before4);


    }

    @Test
    public void getContent() throws Exception {
        String html = "著作权归作者所有。<br>商业转载请联系作者获得授权，非商业转载请注明出处。<br>作者：Simbelmyne<br>链接：<a href=\"http://zhuanlan.zhihu.com/p/20712760\" class=\"\">http://zhuanlan.zhihu.com/p/20712760</a><br>来源：知乎<br><br>【本专栏所有文章翻译自DSM-5临床案例集，DSM-5 Clinical Casebook，作交流、科普所用，请勿随意对号入座。如认为自己的心理障碍严重影响了正常工作、学习和生活，请及时就医】<p>Doug Stamper是《纸牌屋》中我最喜欢的人物之一。在第一季中，他曾出现在Alcoholics Anonymous (AA) 会议上，在那里接触了Peter Russo。他在AA的自我介绍中说自己已经5185天没有碰酒。为了维持不碰酒精的状态，他必须对自己毫不留情。AA是在美国广泛存在的组织，帮助想戒酒的人组成小组，匿名分享自己的故事，鼓励对方和自己保持清醒，达到一定纪念日（如一个月、一年）还会有奖章激励自己。（p.s. 搏击俱乐部的主角在癌症互助小组遇见了他的女友）。</p><p>酒精使用疾患是DSM-5中对“酗酒”的最新用语。根据Wikipedia，据世界卫生组织估计，2010年全球有2.08亿人酒精中毒。酒精的过度摄入不仅会造成多种疾病，而且会产生巨大的经济和社会负担。与家人好友小酌两杯是为怡情，但如果你的家人朋友有酒精成瘾症状，请不要忽视背后的隐患，多多关注他们和自己的健康。</p><p><b><u>案例16.1 一名“典型”酒鬼</u></b></p><p>作者：Marc A. Schuckit, M.D.</p><p>译者：Simbelmyne</p><p>T先生是一名45岁的水管工。家人发现他的酗酒问题越来越难以控制，通过干预措施表达了他们的担忧，后将他介绍给精神科医师作评估。T先生表示自从3天前预约了精神科医师，他就没有碰过酒。</p><p>在高中毕业后的20年中，T先生一周有五个晚上喝3－5瓶啤酒。在过去7年中，他几乎每天饮酒，工作日晚上平均喝6瓶啤酒，周末和节假日则会喝12瓶。他的妻子多次表达过担忧，说“他喝得太多了”，但是尽管T先生努力控制自己的饮酒量，他还是会花周末的大多数时间喝酒，有时会缺席家庭聚会，经常在傍晚看电视的时候睡着。不过，他的工作表现正常，从未请过病假。从各方面来看，他的病史和“典型酗酒者”非常类似。T先生在过去4年中有两次长达一个月的戒酒期。在这两段时间内，他因为妻子的担心完全不摄入酒精，也没有酒精戒断的不适症状。</p><p>在过去6个月中，T先生和往常不同，变得易怒、疲倦、烦躁不安、情绪忧虑。他不再享受自己的日常生活，包括美食和性，注意力也难以集中。他对压力源会产生更强烈的情绪反应，对自己生意的未来发展表达了无依据的担忧。T先生经常在凌晨2点醒来，无法重新入睡。</p><p>T先生和妻子表示虽然他这段情绪低落期持续了6个月，他在过去的5年中有过几次类似经历，每次大约时长4-6个星期。他之前的人生阶段并没有这样的经历。</p><p>T先生结婚18年，与妻子有一个17岁的女儿。他高中毕业后读了两年社区大学，现在自己开了一家生意兴隆的水管公司。T先生表示没有其它精神和生理病史，无躁狂时期，无自杀行为。他之前从未和精神科医师接触过。</p><p>在最近的年度体检中，T先生的内科医生发现他的血压略高（135/92），GGT值为47IU／L，红细胞平均值为92.5。其它体检结果均为正常。</p><p>在第一次面谈时，T先生衣着整洁，眼神接触良好，无精神症状和神智不清的状态。他在谈到未来发展时眼中含泪，表示在过去六个月中大多数时候都情绪低落，但否认有自杀企图或计划。他的认知完整，认识到了酒精对他的影响。</p><p>精神科医师的体检显示他的脉搏正常，无颤抖或出汗现象，血压只是稍稍略高。</p><p><b>诊断</b>：酒精使用疾患（AUD），酒精导致的抑郁症</p><p><b>讨论</b>：</p><p>T先生有2个符合DSM 5标准的诊断。其一是AUD，表现为他曾试图减少饮酒量但是失败、过多时间处于醉酒和醒酒状态、缺席重要的社交场合、以及在发现问题的情况下继续饮酒。在临床评估中，尽管他在过去3天内没有饮酒，T先生未表现出酒精戒断症候。在以前试图戒酒的期间，T先生也否认有酒精戒断症候。</p><p>另一个诊断和他的情绪症状有关。T先生符合重度抑郁发作的症状标准，发作期为6个月前。他表示自己的情绪持续低落、对生活中的事失去兴趣、阶段性失眠、注意力下降和感觉疲劳。他在过去5年中有过几段这样的情绪，在戒酒4-6周后会自行消失。</p><p>我们需要鉴别两种抑郁症状发作：其一是只在大量饮酒的情况下发作，其二是在和过度饮酒无关的情况下发生。在第二种情况中，如果病人已有AUD，抑郁症状很可能按照重度抑郁发作的常规走向发展，有类似的发作时间，通常疗法也有相似疗效。T先生的情况是只在大量饮酒的情况下产生抑郁症状，这种病症非常不同。这些抑郁症状更合适的名称为“酒精导致的抑郁症”，在戒酒几周到一个月后很可能会消退或消失。几乎没有数据表明这样的抑郁症患者需要服用抗抑郁药物，而且病人一旦停止大量饮酒，抑郁症状会快速消减到重度抑郁发作的诊断阈值以下，时间比抗抑郁药物起作用的时间还要短。一些亚阈值症状（如睡眠问题）可能会持续存在，但只要维持戒酒状态，睡眠质量会有所提高。如果在戒酒一个月之后，符合重度抑郁发作诊断的症状持续存在，那么T先生的诊断应该是独立的重度抑郁症，不过临床医生可能将酗酒问题视为抑郁触发事件。</p><p><b>建议阅读</b>：</p><p>Babor, T. F., Higgins-Biddle, J. C., Dauser, D., Burleson, J. A., Zarkin, G. A., &amp; Bray, J. (2006). Brief interventions for at-risk drinking: patient outcomes and cost-effectiveness in managed care organizations. <i>Alcohol and Alcoholism</i>, <i>41</i>(6), 624-631.<br></p><p>Schuckit, M. A. (2009). Alcohol-use disorders. <i>The Lancet</i>, <i>373</i>(9662), 492-501.<br></p><p>Schuckit, M. A., &amp; Smith, T. L. (2011). Onset and course of alcoholism over 25 years in middle class men. <i>Drug and alcohol dependence</i>, <i>113</i>(1), 21-28.</p>";
        Log.d(TAG,commonMethod.getContent(html));

    }

    public static String getTime(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        //2016-04-06 11:56:11
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);

        } catch (ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return re_time;
    }


}