
// Java Program for union-find algorithm to detect cycle in a Union_find

class Union_find
{
    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges
 
    class Edge
    {
        int src, dest;
    };
 
    // Creates a Union_find with V vertices and E edges
    Union_find(int v,int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find the subset of an element i
    int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
 
    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
 
 
    // The main function to check whether a given Union_find
    // contains cycle or not
    int isCycle( Union_find Union_find)
    {
        // Allocate memory for creating V subsets
        int parent[] = new int[Union_find.V];
 
        // Initialize all subsets as single element sets
        for (int i=0; i<Union_find.V; ++i)
            parent[i]=-1;
 
        // Iterate through all edges of Union_find, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in Union_find.
        for (int i = 0; i < Union_find.E; ++i)
        {
            int x = Union_find.find(parent, Union_find.edge[i].src);
            int y = Union_find.find(parent, Union_find.edge[i].dest);
 
            if (x == y)
                return 1;
 
            Union_find.Union(parent, x, y);
        }
        return 0;
    }
 
    // Driver Method
    public static void main (String[] args)
    {
        /* Let us create following Union_find
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        Union_find Union_find = new Union_find(V, E);
 
        // add edge 0-1
        Union_find.edge[0].src = 0;
        Union_find.edge[0].dest = 1;
 
        // add edge 1-2
        Union_find.edge[1].src = 1;
        Union_find.edge[1].dest = 2;
 
        // add edge 0-2
        Union_find.edge[2].src = 0;
        Union_find.edge[2].dest = 2;
 
        if (Union_find.isCycle(Union_find)==1)
            System.out.println( "Union_find contains cycle" );
        else
            System.out.println( "Union_find doesn't contain cycle" );
    }
}