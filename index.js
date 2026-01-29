import { loadDomain, compileDomain } from "./engine.js";
import renderHierarchy from "./render/hierarchy.js";

const domain = loadDomain("./domain");
const compiled = compileDomain(domain);

const svg = renderHierarchy(compiled);
console.log(svg);
