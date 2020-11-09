package LinkedLists;


public class CustomList
{
    private String content;
    private CustomList next;
    private CustomList previous;
    
    public CustomList(String c){
        content = c;
        previous = null;
        next = null;
    }

    public CustomList(String c, CustomList n){
        content = c;
        next = n;
    }
    
    public CustomList(CustomList p, String c, CustomList n){
        previous = p;
        content = c;
        next = n;
    }

    public String getContent(){
        return content;
    }

    public CustomList getNext(){
        return next;
    }

    public void setNext(CustomList n){
        next = n;
    }

    public CustomList getPrevious(){ 
        return previous; 
    }

    public void setPrevious(CustomList p){ 
        previous = p; 
    }


    public void add(String c){
        CustomList temp = this;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        CustomList newNode = new CustomList(temp,c,null);
        temp.setNext(newNode);
    }

    public void add(int index, String c){
        if(index == 0){
            String content = this.content;
            CustomList next = this.next;
            this.content = c;
            this.next = new CustomList(null, content, next);
            next.previous = this.next;
            this.next.previous = this;            
        }
        else if(index < this.size()-1){
            CustomList before = getReference(index-1);
            CustomList next = new CustomList(before, c, before.next);
            before.next.setPrevious(next);
            before.next = next;
        }
        else{
            this.add(c);
        }
    }

    public void set(int index, String c){
        getReference(index).content = c;
    }

    public CustomList getReference(int index){
        CustomList node = this;
        for(int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    } 

    public int size(){
        int length = 1;
        CustomList temp = this;
        while(temp.getNext() != null){
            temp = temp.getNext();
            length++;
        }
        return length;
    }
    
    public String get(int index){
        CustomList temp = this;
        for(int i = 0; i < index; i++){
            temp = temp.getNext();
            }
            return temp.getContent();
        }


    public CustomList remove(int index){
        CustomList get = getReference(index);
        if(index == 0){
            CustomList point = this.next;
            this.next = point.next;
            this.content = point.content;
            point.previous = null;
        }
        else if(index < this.size()-1){
            CustomList before = getReference(index-1);
            CustomList next = before.next;
            before.next = next.next;
        }
        else{
            getReference(index-1).next = null;
        }
        return get;
    }

    public String toString(){
        String answer = "list contains " + content + " ";
        CustomList temp = this;
        while(temp.getNext() != null){
            temp = temp.getNext();
            answer += temp.getContent() + " ";
        }
        return answer;
    }
    
    public String backWords(){
        String list = "reversed list contains ";
        CustomList temp = getReference(size()-1);
        while(temp != null){
            list += temp.getContent() + " ";
            temp = temp.getPrevious();
        }
        return list;
    }
}

