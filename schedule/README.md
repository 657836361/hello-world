一.cron表达式

	1.cron一般是6个部分或是7个部分：如下所示：
	
		1). Seconds （秒） 
		2). Minutes （分） 
		3). Hours （时） 
		4). Day-of-Month （天） 
		5). Month （月） 
		6). Day-of-Week （周） 
		7). Year (年 可选字段) 


	2.cron规则如下:
	
		1). Seconds (秒) ：可以用数字0－59 表示；
		2). Minutes(分) ：可以用数字0－59 表示；
		3). Hours(时) ：可以用数字0-23表示；
		4). Day-of-Month(天) ：可以用数字1-31 中的任一一个值，但要注意一些特别的月份2月份没有只能1-28，有些月份没有31；
		5). Month(月) ：可以用0-11 或用字符串 “JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV and DEC” 表示；
		6). Day-of-Week(*每周*)*：*可以用数字1-7表示（1 ＝ 星期日）或用字符口串“SUN, MON, TUE, WED, THU, FRI and SAT”表示；
		7). “/”：为特别单位，表示为“每”如“0/10”表示每隔10分钟执行一次,“0”表示为从“0”分开始, “3/20”表示表示每隔20分钟执行一次，“3”表示从第3分钟开始执行；
		8). “?”：表示每月的某一天，或第周的某一天；
		9). “L”：用于每月，或每周，表示为每月的最后一天，或每个月的最后星期几如“6L”表示“每月的最后一个星期五”；
		10). “W”：表示为最近工作日，如“15W”放在每月（day-of-month）字段上表示为“到本月15日最近的工作日”；
		11). “#”：是用来指定“的”每月第n个工作日,例 在每周（day-of-week）这个字段中内容为”6#3” or “FRI#3” 则表示“每月第三个星期五”；
		12). “*” 代表整个时间段。
		
二.@Schedule注解解释：

	1.String cron() default ""; 
		cron表达式
	2.String zone() default "";
		时区
	3.long fixedDelay() default -1;
		即表示从上一个任务调用完成后到下一个任务执行的间隔，单位是毫秒。
	4.String fixedDelayString() default "";
		即表示从上一个任务调用完成后到下一个任务执行的间隔，单位是毫秒。
	5.long fixedRate() default -1;
		间隔多久执行任务，单位是毫秒。
	6.String fixedRateString() default "";
		间隔多久执行任务，单位是毫秒。
	7.long initialDelay() default -1;
		初始化的时候延迟多久执行
	8.String initialDelayString() default "";
		初始化的时候延迟多久执行
		
		
