{
  description = "Java dev environment";
  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  outputs = { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs = import nixpkgs { inherit system; };
    in
    {
      devShells.${system}.default = pkgs.mkShell {
        buildInputs = with pkgs; [ temurin-bin-25 jdt-language-server gradle ];
        JAVA_HOME = "${pkgs.temurin-bin-25}";
      };
    };
}

