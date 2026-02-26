export interface Power {
  id: number;
  nome: string;
  descricao: string;
  nivel_inutilidade: number;
}

export interface PowerResponse {
  _embedded: {
    powers: Power[];
  };
}
