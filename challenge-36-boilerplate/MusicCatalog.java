public class MusicCatalog {
    public MusicNode startPtr;

    public void addMusicItems(MusicalItem data){
        MusicNode newNode = new MusicNode(data);
        MusicNode temp = null;

        if(startPtr == null){
            startPtr = newNode;
            startPtr.previous = null;
        }
        else if(isInAscendingOrder(newNode.data, startPtr.data)){
            newNode.next = startPtr;
            newNode.next.previous = newNode;
            startPtr = newNode;
        }
        else{
            temp = startPtr;
            while(temp.next!=null && !isInAscendingOrder(newNode.data, temp.next.data)){
                temp = temp.next;
            }
            newNode.next = temp.next;
            if(temp.next != null)
                newNode.next.previous = newNode;
            temp.next = newNode;
            newNode.previous = temp;
        }
    }

    private boolean isInAscendingOrder(MusicalItem newItem, MusicalItem oldItem){
        if((oldItem.getArtistName()+oldItem.getYearOfRelease()).compareTo((newItem.getArtistName()+newItem.getYearOfRelease())) >= 0)
            return true;
        else
            return false;
    }

    public void traverse(){
        MusicNode current = startPtr;
        if(current == null)
            return;
        while(current != null)
        {
            current.data.showDetails();
            current = current.next;
        }

    }

    void showMusicCatalog(Direction direction){
        String dir = direction.toString();
        if(dir.compareTo("FORWARD") == 0){
            MusicNode current = startPtr;
            if(current == null)
                return;
            while(current != null)
            {
                current.data.showDetails();
                current = current.next;
            }
        }
        else if(dir.compareTo("REVERSE") == 0){
            MusicNode current = startPtr;
            while(current.next != null)
            {
                current = current.next;
            }
            while(current!=null)
            {
                current.data.showDetails();
                current = current.previous;
            }
        }
    }

    void showMusicCatalogSongName(Direction direction, String key){
        String dir = direction.toString();
        if(dir.compareTo("FORWARD") == 0){
            MusicNode current = startPtr;
            if(current == null)
                return;
            while(current != null)
            {
                if(current.data.getMusicItem().toLowerCase().compareTo(key.toLowerCase()) == 0)
                    current.data.showDetails();
                current = current.next;
            }
        }
        else if(dir.compareTo("REVERSE") == 0){
            MusicNode current = startPtr;
            while(current.next != null)
            {
                current = current.next;
            }
            while(current!=null)
            {
                if(current.data.getMusicItem().toLowerCase().compareTo(key.toLowerCase()) == 0)
                    current.data.showDetails();
                current.data.showDetails();
                current = current.previous;
            }
        }
    }

    void showMusicCatalogArtistName(Direction direction, String key){
        String dir = direction.toString();
        if(dir.compareTo("FORWARD") == 0){
            MusicNode current = startPtr;
            if(current == null)
                return;
            while(current != null)
            {
                if(current.data.getArtistName().toLowerCase().compareTo(key.toLowerCase()) == 0)
                    current.data.showDetails();
                current = current.next;
            }
        }
        else if(dir.compareTo("REVERSE") == 0){
            MusicNode current = startPtr;
            while(current.next != null)
            {
                current = current.next;
            }
            while(current!=null)
            {
                if(current.data.getArtistName().toLowerCase().compareTo(key.toLowerCase()) == 0)
                    current.data.showDetails();
                current.data.showDetails();
                current = current.previous;
            }
        }
    }

    void showMusicCatalogGenre(Direction direction, String key){
        String dir = direction.toString();
        if(dir.compareTo("FORWARD") == 0){
            MusicNode current = startPtr;
            if(current == null)
                return;
            while(current != null)
            {
                String[] toCompare = current.data.getGenre().toLowerCase().split("/");
                for(String str:toCompare){
                    if(str.compareTo(key.toLowerCase()) == 0)
                        current.data.showDetails();
                }
                current = current.next;
            }
        }
        else if(dir.compareTo("REVERSE") == 0){
            MusicNode current = startPtr;
            while(current.next != null)
            {
                current = current.next;
            }
            while(current!=null)
            {
                String[] toCompare = current.data.getGenre().toLowerCase().split("/");
                for(String str:toCompare){
                    if(str.compareTo(key.toLowerCase()) == 0)
                        current.data.showDetails();
                }
                current = current.next;
            }
        }
    }
}
