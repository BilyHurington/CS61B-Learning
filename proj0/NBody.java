public class NBody{
	/** Read radius from .txt file */
	public static double readRadius(String path){
		In in=new In(path);
		int n=in.readInt();
		double r=in.readDouble();
		return r;
	}
	/** Read planets from .txt file */
	public static Planet[] readPlanets(String path){
		In in=new In(path);
		int n=in.readInt();
		double r=in.readDouble();
		Planet[] b=new Planet[n];
//		System.out.printf("%d\n",n);
		for(int i=0;i<n;i++){
			b[i]=new Planet();
			b[i].xxPos=in.readDouble();
			b[i].yyPos=in.readDouble();
			b[i].xxVel=in.readDouble();
			b[i].yyVel=in.readDouble();
			b[i].mass=in.readDouble();
			b[i].imgFileName=in.readString();
		}
		return b;
	}
	/** Main method for drawing */
	public static void main(String[] args){

	}
}