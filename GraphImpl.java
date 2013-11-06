package pt.graph;
import java.util.*;

class GraphImpl extends Graph{
	Vector<Node> nodeList = new Vector<Node>();
	Vector<Edge> edgeList = new Vector<Edge>();
	Vector<Arc> arcList = new Vector<Arc>();
	
	void ptGraphOnly(){}
	
	GraphImpl() {}
	
	void newNode(Node n){
		nodeList.add(n);
	}

	void newEdge(Edge e){
		edgeList.add(e);
	}	

	void newArc(Arc a){
		arcList.add(a);
	}
	
	boolean find(Node n){
		for(Node N : nodeList)
			if(N == n)
				return true;
			
		return false;
	}
	
	boolean find(Edge e){
		for(Edge E : edgeList)
			if(E == e)
				return true;
			
		return false;
	}
	
	boolean find(Arc a){
		for(Arc A: arcList)
			if(A == a)
				return true;
			
		return false;
	}
	
	boolean sameXYpos(double xpos, double ypos){
		for(Node n : nodeList)
			if( ((NodeImpl) n).xpos() == xpos && ((NodeImpl) n).ypos() == ypos)
				return true;
			
		return false;
	}
	
	/**
	 * Return a {@link Node}[] of all {@link Node}s in the {@link Graph} g.
	 * The {@link Node} objects in the array must be ordered by their xpos labels.
	 * {@link Node} objects with the same xpos label, are ordered by their ypos labels.
	 *
	 * @param g The {@link Graph}.
	 * @return An array containing all the {@link Node}s in the {@link Graph} g.
	 * @exception InvalidGraphException {@link Graph} g is not of the expected implementation class or is a null pointer.
	 */
	 Node[] allNodes()
	{
		return (Node[])nodeList.toArray(new Node[nodeList.size()]);
	}

	/**
	 * Check to see if the {@link Graph} g contains {@link Arc} objects.
	 *
	 * @param g The {@link Graph} object being checked.
	 * @return true if the {@link Graph} g contains {@link Arc} objects and false otherwise.
	 * @exception InvalidGraphException {@link Graph} g is not of the expected implementation class or is a null pointer.
	 */
	 boolean hasArcs()
	{
		return (arcList.size() == 0) ? false : true;
	}

	/**
	 * Return an {@link Arc}[] of all {@link Arc}s in the {@link Graph} g.
	 * The {@link Arc} objects in the array must be ordered by their source {@link Node}s.
	 * {@link Arc} objects with the same source {@link Node} are ordered by their
	 * destination {@link Node}s. The {@link Node} ordering is the same as in the
	 * {@link Node}[] returned by {@link Graphs#allNodes allNodes()}.
	 *
	 * @param g The {@link Graph}.
	 * @return An array containing all the {@link Arc}s in the {@link Graph} g.
	 * @exception InvalidGraphException {@link Graph} g is not of the expected implementation class
	 * or is a null pointer or it contains {@link Edge} objects.
	 */
	 Arc[] allArcs()
	{
		return (Arc[])arcList.toArray(new Arc[arcList.size()]);
	}

	/**
	 * Check to see if the {@link Graph} g contains {@link Edge} objects.
	 *
	 * @param g The {@link Graph} object being checked.
	 * @return true if the {@link Graph} g contains {@link Edge} objects and false otherwise.
	 * @exception InvalidGraphException {@link Graph} g is not of the expected implementation class or is a null pointer.
	 */
	 boolean hasEdges()
	{
		return (edgeList.size() == 0) ? false : true;
	}

	/**
	 * Return an {@link Edge}[] of all {@link Edge}s in the {@link Graph} g.
	 * The {@link Edge} objects in the array must be ordered by their source {@link Node}s.
	 * {@link Edge} objects with the same source {@link Node} are ordered by their
	 * destination {@link Node}s. The {@link Node} ordering is the same as in the
	 * {@link Node}[] returned by {@link Graphs#allNodes allNodes()}.
	 *
	 * @param g The {@link Graph}.
	 * @return An array containing all the {@link Edge}s in the {@link Graph} g.
	 * @exception InvalidGraphException {@link Graph} g is not of the expected implementation class
	 * or is a null pointer or it contains {@link Arc} objects.
	 */
	 Edge[] allEdges()
	{
		return (Edge[])edgeList.toArray(new Edge[edgeList.size()]);
	}
}

