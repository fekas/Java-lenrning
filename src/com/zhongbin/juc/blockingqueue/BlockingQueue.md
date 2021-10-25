# BlockingQueue

支持阻塞插入(put)和阻塞移除(take)的队列。

## 实现类：

1. ### ArrayBlockingQueue

   三种构造方法：

   ```java
   public ArrayBlockingQueue(int capacity, boolean fair,
                                 Collection<? extends E> c){
     			this(capacity, fair);
   
           final ReentrantLock lock = this.lock;
           lock.lock(); // Lock only for visibility, not mutual exclusion
           try {
               int i = 0;
               try {
                   for (E e : c) {
                       checkNotNull(e);
                       items[i++] = e;
                   }
               } catch (ArrayIndexOutOfBoundsException ex) {
                   throw new IllegalArgumentException();
               }
               count = i;
               putIndex = (i == capacity) ? 0 : i;
           } finally {
               lock.unlock();
           }
   }
   
   public ArrayBlockingQueue(int capacity, boolean fair){
     if (capacity <= 0)
               throw new IllegalArgumentException();
           this.items = new Object[capacity];
           lock = new ReentrantLock(fair);
           notEmpty = lock.newCondition();
           notFull =  lock.newCondition();
   }
   
   public ArrayBlockingQueue(int capacity) {
           this(capacity, false);
       }
   ```

   - 必须传入capacity，默认使用非公平锁

2. ### LinkedBlockingQueue

   构造方法：

   ```java
       public LinkedBlockingQueue() {
           this(Integer.MAX_VALUE);
       }
   
       public LinkedBlockingQueue(int capacity) {
           if (capacity <= 0) throw new IllegalArgumentException();
           this.capacity = capacity;
           last = head = new Node<E>(null);
       }
   
       public LinkedBlockingQueue(Collection<? extends E> c) {
           this(Integer.MAX_VALUE);
           final ReentrantLock putLock = this.putLock;
           putLock.lock(); // Never contended, but necessary for visibility
           try {
               int n = 0;
               for (E e : c) {
                   if (e == null)
                       throw new NullPointerException();
                   if (n == capacity)
                       throw new IllegalStateException("Queue full");
                   enqueue(new Node<E>(e));
                   ++n;
               }
               count.set(n);
           } finally {
               putLock.unlock();
           }
       }
   ```

   

3. ### PriorityBlockingQueue

   构造方法

   ```java
   
       private static final int DEFAULT_INITIAL_CAPACITY = 11;
   		public PriorityBlockingQueue() {
           this(DEFAULT_INITIAL_CAPACITY, null);
       }
   
   		public PriorityBlockingQueue(int initialCapacity) {
           this(initialCapacity, null);
       }
   
       public PriorityBlockingQueue(int initialCapacity,
                                    Comparator<? super E> comparator) {
           if (initialCapacity < 1)
               throw new IllegalArgumentException();
           this.lock = new ReentrantLock();
           this.notEmpty = lock.newCondition();
           this.comparator = comparator;
           this.queue = new Object[initialCapacity];
       }
   
       public PriorityBlockingQueue(Collection<? extends E> c) {}
   
   ```

   

4. ### DelayQueue

   ```java
   public class DelayQueue<E extends Delayed> extends AbstractQueue<E>
       implements BlockingQueue<E> {
     .....
       .....
       .....
   }
   ```

   元素必须实现Delayed接口，来实现创建的元素指定多久才可以中队列中被获取。

5. ### SynchronousQueue

   SynchronousQueue是一个不存储元素的阻塞队列。每一个put操作必须等待一个take操作，否则不能继续添加元素。构造函数如下：

   ```java
   public SynchronousQueue() {
       this(false);
   }
   
   public SynchronousQueue(boolean fair) {
       transferer = fair ? new TransferQueue<E>() : new TransferStack<E>();
   }
   ```

   

6. ### LinkedTeansferQueue

7. ### LinkedBlockingDeque

   