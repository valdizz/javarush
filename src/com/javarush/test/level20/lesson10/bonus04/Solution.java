package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable
{
    private transient Entry<String> header = new Entry<String>(null, null, null, null, null, null, 0);
    private transient int size = 0;
    private transient int level = 0;

    public static void main(String[] args)  throws CloneNotSupportedException, IOException, ClassNotFoundException{
//        List<String> listTree = new Solution();
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//        System.out.println(listTree);
//
//        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
//        List<String> list2222 = new Solution();
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        list2222.add("test");
//        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
//        List<String> list1111 = new Solution();
//        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());
//
//        System.out.println("\nExpected 3, actual is " + ((Solution) listTree).getParent("8"));
//        listTree.remove("5");
//        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
//        listTree.clear();
//        for (int i = 1; i < 16; i++) {
//            listTree.add(String.valueOf(i));
//        }
//
//        //For additional check correct work clone method
//        Solution list = ((Solution)listTree).clone();
//
//        System.out.println("Start value with using clone: " + listTree);
//        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
//        list.remove("2");
//        list.remove("9");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
//        list.add("16");
//        list.add("17");
//        list.add("18");
//        list.add("19");
//        list.add("20");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== REMOVE 18 and 20 =====");
//        list.remove("18");
//        list.remove("20");
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n===== ADD 21 and 32 =====");
//        list.add("21");
//        list.add("22");
//        list.add("23");
//        list.add("24");
//        list.add("25");
//        list.add("26");
//        list.add("27");
//        list.add("28");
//        list.add("29");
//        list.add("30");
//        list.add("31");
//        list.add("32");
//        //list.add(null);
//        for (String s : list) System.out.print(s+ " ");
//        System.out.println("\n---------------------------------------");
//        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
//        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
//        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
//        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
//        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
//        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
//        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
//        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
//        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
//        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
//        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
//        System.out.println("--->> By task and add more item:");
//        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
//        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
//        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
//        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
//        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
//        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
//        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
//        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
//        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
//        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
//        System.out.println("---------------------------------------");
//        System.out.println("Size array = " + list.size() + " expected = 22");
//        System.out.println();
//
//        System.out.println("=============== Clone test ==================");
//
//        System.out.println("Object: " + list + " --> Size = " + list.size());
//        Solution sol = list.clone();
//        //list.remove("7"); //Select for test
//        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
//        System.out.println("Result: " + list.containsAll(sol));
//
//        System.out.println("\nTest addAll: ");
//        Solution add = new Solution();
//        add.addAll(sol);
//        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());
//
//        System.out.println("=============== Iterator test ===============");
//        Iterator<String> itr = list.iterator();
//        while (itr.hasNext()) {
//            String a = itr.next();
//            System.out.print(a + " ");
//        }
//        System.out.println("\nExpected size 22 = " + list.size());
//
//        System.out.println("\nIter remove");
//        Iterator<String> itr2 = list.iterator();
//        while (itr2.hasNext()) {
//            if (itr2.next().contains("31")) {
//                itr2.remove();
//            }
//        }
//        System.out.println("For test " + list + " --> Size = " + list.size());
//        System.out.println("Collect size " + list.size() + " Expected 21");
//
//        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
//        System.out.println("Collect before serializable " + list);
//        System.out.print("Save list");
//        FileOutputStream fos = new FileOutputStream("file");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
//        oos.close();
//        fos.close();
//        System.out.println(" Serializable done");
//        System.out.print("Load list");
//        FileInputStream fis = new FileInputStream("file");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        List<String> list2 = (List<String>) ois.readObject();
//        ois.close();
//        fis.close();
//        System.out.println(" Deserializable done");
//        System.out.println("Collect after deserializable " + list2);
//
//        System.out.println("\n================ Clear test =================");
//        System.out.println("Before: " + listTree);
//        listTree.clear();
//        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));


        System.out.println("===========Adding all 1=============");
        List<String> list = new Solution();
        for (int i = 1; i < 15; i++) {
            list.add("1");
        }
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 14");
        list.remove("1");
        System.out.println("==========After removing 1===========");
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 0");

        System.out.println("=========Adding 1,2 & all 1===========");
        list.add("1");
        list.add("2");
        for (int i = 1; i < 13; i++) {
            list.add("1");
        }
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 14");
        list.remove("1");
        System.out.println("==========After removing 1===========");
        System.out.println(list);
        System.out.println("List is empty? " + list.isEmpty());
        System.out.println("List size is " + list.size() + ", expected 1");
    }

    public String getParent(String value) {
        //have to be implemented
        if (value==null){
            for (Entry<String> e = header.next; e != header; e = e.next) {
                if (e.element==null) {
                    return e.parent.element;
                }
            }
        }
        else {
            for (Entry<String> e = header.next; e != header; e = e.next) {
                if (value.equals(e.element)) {
                    return e.parent.element;
                }
            }
        }
        return "null";
    }


    public Solution() {
        header.next = header.previous = header;
    }

    public Solution(Collection<? extends String> c) {
        this();
        addAll(c);
    }

    public String getFirst() {
        if (size==0)
            throw new NoSuchElementException();

        return header.next.element;
    }

    public String getLast()  {
        if (size==0)
            throw new NoSuchElementException();

        return header.previous.element;
    }

    public String removeFirst() {
        return remove(header.next);
    }

    public String removeLast() {
        return remove(header.previous);
    }

    public void addFirst(String e) {
        addBefore(e, header.next);
    }

    public void addLast(String e) {
        addBefore(e, header);
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int size() {
        return size;
    }

    public boolean add(String e) {
        addBefore(e, header);
        return true;
    }

    public boolean remove(Object o) {
        if (o==null) {
            while (true) {
                boolean flag = true;
                for (Entry e = header.next; e != header; e = e.next) {
                    if (e == null)
                        break;
                    if (e.element==null)
                    {
                        remove(e);
                        flag = false;
                    }
                }
                if (flag)
                    break;
            }
        } else {
            while (true) {
                boolean flag = true;
                for (Entry e = header.next; e != header; e = e.next) {
                    if (e == null)
                        break;
                    if (o.equals(e.element))
                    {
                        remove(e);
                        flag = false;
                    }
                }
                if (flag)
                    break;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends String> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: "+index+
                    ", Size: "+size);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew==0)
            return false;
        modCount++;

        Entry<String> successor = (index==size ? header : entry(index));
        Entry<String> predecessor = successor.previous;
        for (int i=0; i<numNew; i++) {
            Entry<String> e = new Entry<String>((String)a[i], successor, predecessor, null, null, null, 0);
            predecessor.next = e;
            predecessor = e;
        }
        successor.previous = predecessor;

        size += numNew;
        return true;
    }

    public void clear() {
        Entry<String> e = header.next;
        while (e != header) {
            Entry<String> next = e.next;
            e.next = e.previous = e.parent = e.left = e.right = null;
            e.element = null;
            e = next;
        }
        header.next = header.previous = header;
        header.parent = header.left = header.right = null;
        size = 0;
        modCount++;
    }


    // Positional Access Operations

    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
//        Entry<String> e = entry(index);
//        String oldVal = e.element;
//        e.element = element;
//        return oldVal;
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        //addBefore(element, (index==size ? header : entry(index)));
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        //return remove(entry(index));
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the indexed entry.
     */
    private Entry<String> entry(int index) {
//        if (index < 0 || index >= size)
//            throw new IndexOutOfBoundsException("Index: "+index+
//                    ", Size: "+size);
//        Entry<String> e = header;
//        if (index < (size >> 1)) {
//            for (int i = 0; i <= index; i++)
//                e = e.next;
//        } else {
//            for (int i = size; i > index; i--)
//                e = e.previous;
//        }
//        return e;
        throw new UnsupportedOperationException();
    }


    // Search Operations

    public int indexOf(Object o) {
        int index = 0;
        if (o==null) {
            for (Entry e = header.next; e != header; e = e.next) {
                if (e.element==null)
                    return index;
                index++;
            }
        } else {
            for (Entry e = header.next; e != header; e = e.next) {
                if (o.equals(e.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;
        if (o==null) {
            for (Entry e = header.previous; e != header; e = e.previous) {
                index--;
                if (e.element==null)
                    return index;
            }
        } else {
            for (Entry e = header.previous; e != header; e = e.previous) {
                index--;
                if (o.equals(e.element))
                    return index;
            }
        }
        return -1;
    }

    public String element() {
        return getFirst();
    }

    public String remove() {
        return removeFirst();
    }


    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }


    public boolean removeLastOccurrence(Object o) {
        if (o==null) {
            for (Entry<String> e = header.previous; e != header; e = e.previous) {
                if (e.element==null) {
                    remove(e);
                    return true;
                }
            }
        } else {
            for (Entry<String> e = header.previous; e != header; e = e.previous) {
                if (o.equals(e.element)) {
                    remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListItr(0);
    }

    private class ListItr implements Iterator<String> {
        private Entry<String> lastReturned = header;
        private Entry<String> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index: "+index+
                        ", Size: "+size);
            if (index < (size >> 1)) {
                next = header.next;
                for (nextIndex=0; nextIndex<index; nextIndex++)
                    next = next.next;
            } else {
                next = header;
                for (nextIndex=size; nextIndex>index; nextIndex--)
                    next = next.previous;
            }
        }

        public boolean hasNext() {
            return nextIndex != size;
        }

        public String next() {
            checkForComodification();
            if (nextIndex == size)
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }

        public boolean hasPrevious() {
            return nextIndex != 0;
        }

        public String previous() {
            if (nextIndex == 0)
                throw new NoSuchElementException();

            lastReturned = next = next.previous;
            nextIndex--;
            checkForComodification();
            return lastReturned.element;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex-1;
        }

        public void remove() {
            checkForComodification();
            Entry<String> lastNext = lastReturned.next;
            try {
                Solution.this.remove(lastReturned);
            } catch (NoSuchElementException e) {
                throw new IllegalStateException();
            }
            if (next==lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = header;
            expectedModCount++;
        }

        public void set(String e) {
            if (lastReturned == header)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.element = e;
        }

        public void add(String e) {
            checkForComodification();
            lastReturned = header;
            addBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private static class Entry<String> {
        String element;
        Entry<String> next;
        Entry<String> previous;
        Entry<String> parent;
        Entry<String> left;
        Entry<String> right;
        int level;

        Entry(String element, Entry<String> next, Entry<String> previous, Entry<String> parent, Entry<String> left, Entry<String> right, int level) {
            this.element = element;
            this.next = next;
            this.previous = previous;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.level = level++;
        }
    }

    private Entry<String> addBefore(String e, Entry<String> entry) {
        level++;
        Entry<String> newEntry = new Entry<String>(e, entry, entry.previous, null, null, null, level);
        if (entry.previous.equals(header)){
            if (header.left == null){
                header.left = newEntry;
                newEntry.parent = header;
            }
            else if (header.right == null){
                header.right = newEntry;
                newEntry.parent = header;
            }
        }
        else if (entry.previous.parent.right==null){
            entry.previous.parent.right = newEntry;
            newEntry.parent = entry.previous.parent;
        }
        else {
            entry.previous.parent.next.left = newEntry;
            newEntry.parent = entry.previous.parent.next;
        }
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        size++;
        modCount++;
        return newEntry;
    }

    private String remove(Entry<String> e) {
        if (e == header)
            throw new NoSuchElementException();

        String result = e.element;
        e.previous.next = e.next;
        e.next.previous = e.previous;
        if (e.parent.left != null && e.parent.left.equals(e))
            e.parent.left = null;
        else if (e.parent.right != null && e.parent.right.equals(e))
            e.parent.right = null;
        e.next = e.previous = e.parent = null;
        e.element = null;
        if (e.left != null){
            remove(e.left);
        }
        if (e.right != null){
            remove(e.right);
        }
        size--;
        modCount++;
        return result;
    }

    public Iterator<String> descendingIterator() {
        return new DescendingIterator();
    }

    private class DescendingIterator implements Iterator {
        final ListItr itr = new ListItr(size());
        public boolean hasNext() {
            return itr.hasPrevious();
        }
        public String next() {
            return itr.previous();
        }
        public void remove() {
            itr.remove();
        }
    }

    /**
     * Returns a shallow copy of this <tt>LinkedList</tt>. (The elements
     * themselves are not cloned.)
     *
     * @return a shallow copy of this <tt>LinkedList</tt> instance
     */
    public Solution clone() {
        Solution clone = null;
        try {
            clone = (Solution) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }

        // Put clone into "virgin" state
        clone.header = new Entry<String>(null, null, null, null, null, null, 0);
        clone.header.next = clone.header.previous = clone.header;
        clone.size = 0;
        clone.modCount = 0;

        // Initialize clone with our elements
        for (Entry<String> e = header.next; e != header; e = e.next)
            clone.add(e.element);

        return clone;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list
     *         in proper sequence
     */
    public String[] toArray() {
        String[] result = new String[size];
        int i = 0;
        for (Entry<String> e = header.next; e != header; e = e.next)
            result[i++] = e.element;
        return result;
    }

    private static final long serialVersionUID = 876323262645179354L;

    /**
     * Save the state of this <tt>LinkedList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The size of the list (the number of elements it
     *             contains) is emitted (int), followed by all of its
     *             elements (each an Object) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out size
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Entry e = header.next; e != header; e = e.next)
            s.writeObject(e.element);
    }

    /**
     * Reconstitute this <tt>LinkedList</tt> instance from a stream (that is
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // Read in size
        int size = s.readInt();

        // Initialize header
        header = new Entry<String>(null, null, null, null, null, null, 0);
        header.next = header.previous = header;

        // Read in all elements in the proper order.
        for (int i=0; i<size; i++)
            addBefore((String)s.readObject(), header);
    }

}
