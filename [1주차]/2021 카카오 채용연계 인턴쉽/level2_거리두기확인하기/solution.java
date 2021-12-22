public class Solution {
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i<5; i++){
            String[] place = places[i];
            String[][] seats = placeToSeats(place);
            int data = isCandidateKeepDistance(seats);
            answer[i] = data;
        }
        return answer;
    }
    public static String[][] placeToSeats(String[] place){
        int size = 5;
        String[][] seats = new String[size][size];
        for(int y = 0; y<size; y++){
            String placeLine = place[y];
            String[] ySeats = placeLine.split("");
            System.arraycopy(ySeats, 0, seats[y], 0, size);
        }
        return seats;
    }

    public static int isCandidateKeepDistance(String[][] seats){
        int size = 5;
        for(int y=0;y<size;y++){
            for(int x=0;x<size;x++){
                if(seats[y][x].equals("X"))
                    continue;
                boolean isCandidate = seats[y][x].equals("P");
                Point currentPoint = new Point(x,y);
                int candidateCount = 0;
                for(int i=0;i<4;i++){
                    int moveX = currentPoint.x + dx[i];
                    int moveY = currentPoint.y + dy[i];
                    Point movePoint = new Point(moveX,moveY);
                    if(moveValidation(movePoint,5)){
                        if(seats[moveY][moveX].equals("P")){
                            if(isCandidate)
                                return 0;
                            candidateCount++;
                        }
                        if(!isCandidate && candidateCount > 1)
                            return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static boolean moveValidation(Point point, int max){
        return point.x >=0 && point.y >=0 && point.x < max && point.y < max;
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
