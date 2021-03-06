public class Persona {

	private String nombre;
	private int edad;
	private String municipio;
	private String colegio;
	private String lugarTrabajo;
	
	private Persona() {}
	

	public static class Builder {
		private Persona persona;
		
		public Builder(String nombre) {
			persona = new Persona();
			persona.nombre = nombre;
		}
		
		public Builder setMunicipio (String municipio) {
			persona.municipio = municipio;
			return this;
		}
		public BuilderMayor setMayor(int edad) {
			if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
			persona.edad = edad;
			persona.colegio = null;
			return new BuilderMayor(persona);
		}

		public BuilderMenor setMenor(int edad) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;
			persona.lugarTrabajo = null;
			return persona.new BuilderMenor(persona);
		}

        public Persona build() {
            return persona;
        }


	}
	public static class BuilderMayor{
		Persona persona;

		public BuilderMayor(Persona persona){
		    this.persona=persona;
        }

		public BuilderMayor setLugarTrabajo(String lugarTrabajo) {
			if (persona.edad < 18) throw new IllegalArgumentException("es menor de edad " + persona.edad);
			persona.lugarTrabajo = lugarTrabajo;
			return this;}

        public Persona build() {
            return persona;
        }

	}
	public class BuilderMenor{

        private Persona persona;

        public BuilderMenor(Persona persona){
	        this.persona=persona;
        }

        public BuilderMenor setColegio(String colegio) {
            if (persona.edad >= 18) throw new IllegalArgumentException("es mayor de edad " + persona.edad);
            persona.colegio = colegio;
            persona.lugarTrabajo = null;
            return this;
        }
        public Persona build() {
            return persona;
        }
    }
	public String toString(){
		String persona="";
		persona="Nombre: "+ this.nombre+"\n"+
				"Edad: "+ this.edad+"\n";
		if (this.municipio != null){
			persona=persona+"Municipio: "+ this.municipio+"\n";
		}
		if (this.lugarTrabajo != null){
			persona=persona+"Lugar de Trabajo: "+ this.lugarTrabajo+"\n";
		}
		if (this.colegio != null){
			persona=persona+"Colegio: "+ this.colegio+"\n";};
		return persona;}


}
