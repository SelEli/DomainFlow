import { loadDomain, compileDomain } from "./engine.js";
import renderOrbat from "./render/orbat.js";

const domain = loadDomain("./domain");
const compiled = compileDomain(domain);

const svg = renderOrbat(compiled);
console.log(svg);
