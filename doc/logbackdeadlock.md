# how to reproduce the deadlock
* I make a demo to reproduce the problem.
* problem: the spring project may be deadlocked by log info format message and the projcet start failed. This happened online.
* detailInfo: https://github.com/walkertest/springdemo/blob/main/doc/logbackdeadlock.md

# some env 
```
java.version: 1.8.0_361
springboot: 2.7.15
aspectjweaver: 1.9.20
```

# the steps to reproduce the deadlock
* add a debugpoint
![debugpoint](debugpoint.png)
* start the application in debug mode
![startdebug](startdebug.png)
* wait for 5 seconds or more, and then run debug next line
![waitAndDebug](waitAnddebug.png)
* the application will be deadlocked
![deadlockhappend](deadlockhappened.png)
* the thread dump will show the deadlock
![deadlockstackinfo](deadlokstackinfo.png)
```agsl
* as you can see, the thread `main` and the thred `pool-1-thread-1` are deadlocked for log info format message.
* aspectj weaver is needed for our project.
```

[jstackInfo](26220.txt)

# how to fix the deadlock
I don't know how to fix this problem, wish your response.
