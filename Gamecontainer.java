package com.cmc.engine;

public class Gamecontainer implements Runnable
{
	private Thread thread;
	private Window window;
	//Some stuff
	private boolean running = false;
	private final double UPDATE_CAP = 1.0/60.0;
	private int width=320, height=240;
	private float scale = 1f;
	private String title = "CmcEngine 1.0";
	
	public Gamecontainer() 
	{
		
	}
	public void start()
	{
		window = new Window(this);
		thread = new Thread(this); 
		thread.run();
	}
	public void stop()
	{
		
	}	
	public void run()
	{
		running = true;
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		while(running){
			boolean render = false;
			firstTime  = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			unprocessedTime += passedTime;
			while(unprocessedTime >= UPDATE_CAP)
			{
				unprocessedTime -= UPDATE_CAP;
				render = true;
				//TODO: update game
			}
			if(render){
				//TODO: RenderGame
				window.update();
			}
			else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			dispose();
		}
	}
	private void dispose() 
	{

	}
	public static void main(String[] args) {
		Gamecontainer gc = new Gamecontainer();
		gc.start();
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public float getScale() {
		return scale;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
