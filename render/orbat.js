export default function renderOrbat(domain) {
  const title = domain.units?.[0]?.name || "Domain";

  return `
<svg width="300" height="120" xmlns="http://www.w3.org/2000/svg">
  <rect x="10" y="10" width="280" height="80" fill="#e8e8e8" stroke="#333" />
  <text x="20" y="55" font-size="20" font-family="Arial">${title}</text>
</svg>
  `;
}
