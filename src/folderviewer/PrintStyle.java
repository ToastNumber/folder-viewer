package folderviewer;

public enum PrintStyle {
	Minimal, Fancy;
	
	public static PrintStyle get(String style) throws IllegalArgumentException {
		String s = style.toLowerCase();
		
		if (s.equals("minimal")) return Minimal;
		else if (s.equals("fancy")) return Fancy;
		else throw new IllegalArgumentException("Error: unrecognised style");
	}
}
