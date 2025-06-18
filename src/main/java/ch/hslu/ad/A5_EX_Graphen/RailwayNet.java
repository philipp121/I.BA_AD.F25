package ch.hslu.ad.A5_EX_Graphen;

import java.util.LinkedList;
import java.util.List;

public class RailwayNet {
    // 0 Arth-Goldau | 4
    // 1 Aarau | 3
    // 2 Brugg | 3
    // 3 Dietikon | 4
    // 4 Lenzburg | 7
    // 5 Luzern | 4
    // 6 Pfäffikon | 2
    // 7 Rotkreuz | 4
    // 8 Olten | 3
    // 9 Wohlen | 3
    // 10 Zofingen | 3
    // 11 Zürich | 5
    // 12 Zug | 3
    private final static int EMPTY = -1;
    private int routes;

    int[][] adjMx = new int[13][13];
    int[][] adjMxTrans = new int[13][13];

    public RailwayNet(){
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                adjMx[i][j] = EMPTY;
            }
        }
        adjMx[0][5] = adjMx[5][0] = 30; // Arth-Goldau - Luzern
        adjMx[0][7] = adjMx[7][0] = 15; // Arth-Goldau - Rotkreuz
        adjMx[0][12] = adjMx[12][0] = 20; // Arth-Goldau - Zug
        adjMx[0][6] = adjMx[6][0] = 39; // Arth-Goldau - Pfäffikon

        adjMx[1][2] = adjMx[2][1] = 13; // Aarau - Brugg
        adjMx[1][4] = adjMx[4][1] = 8; // Aarau - Lenzburg
        adjMx[1][8] = adjMx[8][1] = 13; // Aarau - Olten

        adjMx[2][3] = adjMx[3][2] = 16; // Brugg - Dietikon
        adjMx[2][4] = adjMx[4][2] = 16; // Brugg - Lenzburg

        adjMx[3][4] = adjMx[4][3] = 19; // Dietikon - Lenzburg
        adjMx[3][9] = adjMx[9][3] = 30; // Dietikon - Wohlen
        adjMx[3][11] = adjMx[11][3] = 12; // Dietikon - Zürich

        adjMx[4][5] = adjMx[5][4] = 80; // Lenzburg - Luzern
        adjMx[4][9] = adjMx[9][4] = 9; // Lenzburg - Wohlen
        adjMx[4][10] = adjMx[10][4] = 34; // Lenzburg - Zofingen
        adjMx[4][11] = adjMx[11][4] = 19; // Lenzburg - Zürich

        adjMx[5][7] = adjMx[7][5] = 16; // Luzern - Rotkreuz
        adjMx[5][10] = adjMx[10][5] = 35; // Luzern - Zofingen

        adjMx[6][11] = adjMx[11][6] = 30; // Pfäffikon - Zürich

        adjMx[7][12] = adjMx[12][7] = 12; // Rotkreuz - Zug
        adjMx[7][9] = adjMx[9][7] = 23; // Rotkreuz - Wohlen

        adjMx[8][10] = adjMx[10][8] = 7; // Olten - Zofingen
        adjMx[8][11] = adjMx[11][8] = 36; // Olten - Zürich

        adjMx[11][12] = adjMx[12][11] = 25; // Zürich - Zug
        routes = 24;

        adjMxTrans = floydWarshall(adjMx);
    }

    public static void main(String[] args) {
        RailwayNet railwayNet = new RailwayNet();
        //printAdjMx(railwayNet.adjMx);
        //System.out.println(railwayNet.getAmountOfStations());
        //System.out.println(railwayNet.getAmountOfRoutes());
        //System.out.println(railwayNet.routeExists("Zürich", "Olten"));
        //System.out.println(railwayNet.routeExists("Luzern", "Lenzburg"));
        //System.out.println(railwayNet.routeExists("Zug", "Wohlen"));

//        for (int i = 0; i < railwayNet.adjMx.length; i++) {
//            String city = City.fromIndex(i).getName();
//            List<String> routes = railwayNet.getRoutes(city);
//            System.out.println("Routes for " + city + ": ");
//            for (String s : routes){
//                System.out.println("From " + city + " to " + s);
//            }
//        }

        //System.out.println(railwayNet.getRouteTravelTime("Luzern", "Lenzburg"));

        //printAdjMx(RailwayNet.floydWarshall(railwayNet.adjMx));
        System.out.println(railwayNet.getRouteTravelTime("Luzern", "Brugg"));
    }

    public int getAmountOfStations(){
        return adjMx.length;
    }

    public int getAmountOfRoutes(){
        return routes;
    }

    public boolean directRouteExists(String stationA, String stationB){
        int a = City.fromName(stationA).getIndex();
        int b = City.fromName(stationB).getIndex();
        return adjMx[a][b] != -1;
    }

    public int getDirectRouteTravelTime (String stationA, String stationB){
        int a = City.fromName(stationA).getIndex();
        int b = City.fromName(stationB).getIndex();
        if (adjMx[a][b] != -1) {
            return adjMx[a][b];
        } else {
            throw new IllegalArgumentException("No route exists between stations");
        }
    }

    public int getRouteTravelTime (String stationA, String stationB){
        int a = City.fromName(stationA).getIndex();
        int b = City.fromName(stationB).getIndex();
        if (adjMxTrans[a][b] != -1) {
            return adjMxTrans[a][b];
        } else {
            throw new IllegalArgumentException("No route exists between stations");
        }
    }

    public List<String> getRoutes (String station){
        List <String> routes = new LinkedList<>();
        int s = City.fromName(station).getIndex();
        for (int i = 0; i < adjMx.length; i++){
            if (adjMx[s][i] != -1){
                routes.add(City.fromIndex(i).getName());
            }
        }
        return routes;
    }

    public static int[][] floydWarshall(int[][] adja) {
        int nodeCount = adja.length;
        int[][] distance = deepCopy(adja);
        for (int k = 0; k < nodeCount; k++) {
            for (int i = 0; i < nodeCount; i++) {
                for (int j = 0; j < nodeCount; j++) {
                    if (distance[i][k] > -1 && distance[k][j] > -1) {
                        int newDistance = distance[i][k] + distance[k][j];
                        if (distance[i][j] == -1 || newDistance < distance[i][j]) {
                            distance[i][j] = newDistance;
                        }
                    }
                }
            }
        }
        return distance;
    }

    private static int[][] deepCopy(int[][] original){
        if (original == null) return null;

        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone(); // deep copy of each row
        }
        return copy;
    }

    private static void printAdjMx(int[][] adjMx) {
        // Header row
        System.out.printf("%13s", "");
        for (City col : City.values()) {
            System.out.printf("%13s", City.formatCityName(col));
        }
        System.out.println();

        // Matrix rows
        for (City row : City.values()) {
            System.out.printf("%13s", City.formatCityName(row));
            for (City col : City.values()) {
                int value = adjMx[row.getIndex()][col.getIndex()];
                System.out.printf("%13s", value == -1 ? "." : value);
            }
            System.out.println();
        }
    }
}
