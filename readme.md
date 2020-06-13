## Thread & Processes
- Processess are instance of programs typically independent of each other.
- Inside process you can utilize threads to execute code concurrently, to use available cores of the CPU.
- Code to be executed by thread is called Task.
## Executors
- Executors are capable of running asynchornous tasks and typically manage a pool of threads.
- so we don't have to create new thread manually.
- Executors provides convenient factory methods for creating differnt kinds of executor services.
- In addition to  Runnable executors support there is  another kind of  task name called Callable.
- Any call to  future.get() block current thread and wait until callable has terminated.
- ThreadPoolExecuter implementation adds ability to  configure parameters as well as extensibility hooks.
- ForkJoinPool implementation is based on 'work stealing' algorithm. that means the thread that run out the task steal work from other busy threads.
- ForkJoinPool is well suited for cases when most tasks create other subtasks and when many small tasks are added to the pool from external clients.
- ForkJoinPool works slightly differently than other executors, instead of using fixed size thread , ForkJoinPool are create for given parallalism
  size  which per default uses number of avialable cores of the host cpu.
  
## Scheduled Executors
- to execute the common tasks multiple times, we can use utilize 

# References
- https://docs.spring.io/spring/docs/5.3.0-SNAPSHOT/spring-framework-reference/integration.html#scheduling
- https://stackify.com/java-thread-pools/
- https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
