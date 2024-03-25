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
	static final String background="images/starfield.jpg";
	static final double scale=100;
	public static double radius;
	/** Main method for drawing */
	public static void main(String[] args){
		double T=Double.parseDouble(args[0]);
		double dt=Double.parseDouble(args[1]);
		String filename=args[2];
		radius=readRadius(filename);
		Planet[] b=readPlanets(filename);
		int n=b.length;
		StdDraw.setScale(-100, 100);
		StdDraw.clear();
		StdDraw.picture(0,0,background);
		for(int i=0;i<n;i++){
			b[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		double time=0;
		while(time<T){
			double[] xForces=new double[n];
			double[] yForces=new double[n];
			for(int i=0;i<n;i++){
				xForces[i]=b[i].calcNetForceExertedByX(b);
				yForces[i]=b[i].calcNetForceExertedByY(b);
			}
			for(int i=0;i<n;i++){
				b[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.picture(0,0,background);
			for(int i=0;i<n;i++){
				b[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time+=dt;
		}
		StdOut.printf("%d\n",n);
		StdOut.printf("%.2e\n",radius);
		for(int i=0;i<n;i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					b[i].xxPos,b[i].yyPos,b[i].xxVel,
					b[i].yyVel,b[i].mass,b[i].imgFileName);
		}
	}
}