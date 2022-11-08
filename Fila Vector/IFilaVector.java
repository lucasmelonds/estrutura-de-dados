public interface IFilaVector<T> {
  public void enqueue(T newEntry);

  public T dequeue();

  public T first();

  public boolean isEmpty();
}