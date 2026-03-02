export interface Power {
  nome: string;
  descricao: string;
  nivelInutilidade: number;
}

export interface PowerResponse {
  _embedded: {
    superpowers: Power[];
  };
}
